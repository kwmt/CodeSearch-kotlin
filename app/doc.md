# Module app

Android Application
# Package net.kwmt27.codesearch.application

アプリケーション全体に関わるパッケージ。Applicationクラスや、di、logなどを置く。

# Package net.kwmt27.codesearch.presentation

activityやfragment、customviewなどの、Android Frameworkの画面表示を担当する。アニメーションなどの動きもこのパッケージで担当する。

presentation配下のパッケージは、画面ごとに作成する。

* Activity, Fragment or CustomViewなど
    * 画面表示を担当。基本的にはViewModelをつなぐ設定とアニメーションを記述するのみとする。ドメインロジックは書かない。


* ViewModel
    * ActivityやFragmentから受け取ったイベントを処理したり、ActivityやFragmentに値を反映する処理を担当する。
    
* Navigator
    * ViewModelから画面遷移する部分を担当。`startActivityForResult'して前の画面に戻ったときは、
    ```
    何かしらイベント -> ViewModel -> Navigator -> Activity or Fragment(onActivityResult) -> ViewModel
    ```
    となるように、Activity or FragmentのonActivityResultではロジックを書かず、ViewModelに任せるようにする。
    (そのため、ViewModelにonActivityResultを実装漏れがないように、ViewModel インターフェースに `onActivityResult`を実装するように書いておく。)

* diパッケージ
    * 各画面にinjectしたいModuleを記述

# Package net.kwmt27.codesearch.domain

UseCaseを担当。[interactor]のクラスを見れば、どのようなUseCaseがあるか分かるようなクラス名にする。そのクラスには必ず[UseCase]をimplementsしてください。
また、[domain]から外部にデータを取得しに行くための[net.kwmt27.codesearch.domain.repository]インターフェースを定義する。[net.kwmt27.codesearch.domain.repository]インターフェースの実装は[domain]では知らないようにすべきなので[infrastructure]パッケージで実装する。

# Package net.kwmt27.codesearch.infrastructure

APIなどの外部とのやり取りするためのインターフェースを提供する。[entity]は取得してきたデータを格納する。
[net.kwmt27.codesearch.infrastructure.repository]パッケージでは、[entity]を[domain.model]に変換して返すような実装にする。

GithubのAPIで使用するエンドポイントは、[net.kwmt27.codesearch.infrastructure.api.GithubApi.kt]を見れば分かるように実装する。
