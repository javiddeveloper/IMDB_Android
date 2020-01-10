package ir.javid.developer.imdb.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

 class ParentViewModel : ViewModel() {

    var loading = ObservableBoolean(false)
    private val mCompositeDisposable = CompositeDisposable()


     fun addToUnsubscribed(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }

}
