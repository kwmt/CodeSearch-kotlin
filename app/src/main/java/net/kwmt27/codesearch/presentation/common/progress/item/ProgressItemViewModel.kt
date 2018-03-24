package net.kwmt27.codesearch.presentation.common.progress.item

import net.kwmt27.codesearch.application.di.ActivityScope
import net.kwmt27.codesearch.presentation.eventlist.IEventViewModel
import javax.inject.Inject

/**
 * [ProgressView]に対応するViewModel
 */
@ActivityScope
class ProgressItemViewModel @Inject constructor() : EndlessProgressable, IEventViewModel {

    override var loading: Boolean = false
}