# Module app

Android Application

# Package net.kwmt27.codesearch.presentation

[view],[viewmodel]から構成される。

# Package net.kwmt27.codesearch.presentation.view

activityやfragment、customviewなどの、Android Frameworkの画面表示を担当する。アニメーションなどの動きもこのパッケージで担当する。

# Package net.kwmt27.codesearch.presentation.viewmodel

[view]から受け取ったイベントを処理したり、[view]に値を反映する処理を担当する。

# Package net.kwmt27.codesearch.domain

UseCaseを担当。[interactor]のクラスを見れば、どのようなUseCaseがあるか分かるようなクラス名にする。そのクラスには必ず[UseCase]をimplementsしてください。
また、[domain]から外部にデータを取得しに行くための[net.kwmt27.codesearch.domain.repository]インターフェースを定義する。[net.kwmt27.codesearch.domain.repository]インターフェースの実装は[domain]では知らないようにすべきなので[data]パッケージで実装する。

# Package net.kwmt27.codesearch.data

APIなどの外部とのやり取りするためのインターフェースを提供する。[entity]は取得してきたデータを格納する。
[net.kwmt27.codesearch.data.repository]パッケージでは、[entity]を[domain.model]に変換して返すような実装にする。

GithubのAPIで使用するエンドポイントは、[net.kwmt27.codesearch.data.api.GithubApi.kt]を見れば分かるように実装する。