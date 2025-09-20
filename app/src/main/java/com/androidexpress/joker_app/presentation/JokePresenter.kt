package com.androidexpress.joker_app.presentation

import com.androidexpress.joker_app.data.JokeCallback
import com.androidexpress.joker_app.data.JokeRemoteDataSource
import com.androidexpress.joker_app.model.Joke
import com.androidexpress.joker_app.view.JokeFragment

class JokePresenter(
  private val view: JokeFragment,
  private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

  fun findBy(categoryName: String) {
    view.showProgress()
    dataSource.findBy(categoryName, this)
  }

  override fun onSuccess(response: Joke) {
    view.showJoke(response)
  }

  override fun onError(response: String) {
    view.showFailure(response)
  }

  override fun onComplete() {
    view.hideProgress()
  }


}