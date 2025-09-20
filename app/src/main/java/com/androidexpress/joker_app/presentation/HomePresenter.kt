package com.androidexpress.joker_app.presentation

import android.graphics.Color
import com.androidexpress.joker_app.data.CategoryRemoteDataSource
import com.androidexpress.joker_app.data.ListCategoryCallback
import com.androidexpress.joker_app.model.Category
import com.androidexpress.joker_app.view.HomeFragment

class HomePresenter(
  private val view: HomeFragment,
  private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

  fun findAllCategories() {
    view.showProgress()
    dataSource.findAllCategories(this)
  }

  override fun onSuccess(response: List<String>) {
    val start = 40 // H - matiz
    val end = 190 // H - matiz
    val diff = (end - start) / response.size

    val categories = response.mapIndexed { index, s ->
      val hsv = floatArrayOf(
        start + (diff * index).toFloat(),
        100.0f,
        100.0f,
      )

      Category(s, Color.HSVToColor(hsv).toLong())
    }

    view.showCategories(categories)
  }

  override fun onError(response: String) {
    view.showFailure(response)
  }

  override fun onComplete() {
    view.hideProgress()
  }

}






