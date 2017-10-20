package net.kwmt27.codesearch.domain.interactor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import net.kwmt27.codesearch.domain.model.EventModel
import net.kwmt27.codesearch.domain.repository.EventsRepository
import javax.inject.Inject

/**
 * イベントリストを取得するUseCase
 */
class GetEvents @Inject constructor(private val eventRepository: EventsRepository) : UseCase{


    companion object {
        data class Params(val user:String, val page:Int)
    }

    private val disposables = CompositeDisposable()

    fun execute(observer: DisposableSingleObserver<List<EventModel>>, params: Params) {
        val observable = this.eventRepository.events(params.user, params.page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        addDisposable(observable.subscribeWith(observer))
    }



    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun dispose() {
        if(!disposables.isDisposed){
            disposables.dispose()
        }
    }

}