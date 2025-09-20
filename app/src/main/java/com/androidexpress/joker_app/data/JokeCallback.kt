package com.androidexpress.joker_app.data

import com.androidexpress.joker_app.model.Joke

interface JokeCallback {

  fun onSuccess(response: Joke)

  fun onError(response: String)

  fun onComplete()

}