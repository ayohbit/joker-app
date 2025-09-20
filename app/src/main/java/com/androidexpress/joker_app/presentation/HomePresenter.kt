package com.androidexpress.joker_app.presentation

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
    val categories = response.map { Category(it, 0xFFFF0000) }

    view.showCategories(categories)
  }

  override fun onError(response: String) {
    view.showFailure(response)
  }

  override fun onComplete() {
    view.hideProgress()
  }

}

















