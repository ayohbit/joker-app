package com.androidexpress.joker_app.presentation

import com.androidexpress.joker_app.data.JokeCallback
import com.androidexpress.joker_app.data.JokeDayRemoteDataSource
import com.androidexpress.joker_app.data.JokeRemoteDataSource
import com.androidexpress.joker_app.model.Joke
import com.androidexpress.joker_app.view.JokeDayFragment
import com.androidexpress.joker_app.view.JokeFragment

class JokeDayPresenter(
  private val view: JokeDayFragment,
  private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallback {

  fun findRandom() {
    view.showProgress()
    dataSource.findRandom(this)
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