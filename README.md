[![CircleCI](https://circleci.com/gh/kwmt/CodeSearch-kotlin/tree/master.svg?style=svg&circle-token=d377bd718687ac8360bcab92173b31f8aa786ce4)](https://circleci.com/gh/kwmt/CodeSearch-kotlin/tree/master)

## テストについて


Hamcrestのassertを使おうとすると、`is`がKolitnの予約語なため、バッククォートで囲わないといけない
```
assrtThat(1, `is`(1))
```
https://qiita.com/arenahito/items/1d54a6acc77d8ba48362


きれいに書くためには、Hamcrestをやめる必要がある。


KotlinでUnitテストでassertionに何を使うか
https://android.gcreate.jp/398

https://discuss.kotlinlang.org/t/what-assertions-library-do-you-use/1809

などを見ると、kotlintestが良さそう

良さそうな理由は

* Githubスターが多い 525
* ドキュメントが充実
* 活発

でも、`assertEquals` でいい気がしてきた

### Mockito2の設定

kotlinのクラスはデフォルトfinalクラスのため、Mockitoを使ってなにも設定しないと、final classはモック化できないというエラーになります。
そのため、
```
app/src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker
```
ファイルを作成しています。

* 参考 [How to mock final classes on Kotlin using Mockito 2 (KAD 23)](https://antonioleiva.com/mockito-2-kotlin/)


## 命名規則

* リストは複数形にする（Listは命名は使わない）
    * たとえば、EventならEvents
    * EventListとは命名しない
* パッケージ名をクラス名にも付ける
    * repositoryパッケージなら、EventRepositoryクラスとする
* DataSourceパッケージ
    * APIから取得するなら xxxRemoteDataSource
    * ローカルDBなどローカルから取得する場合は、xxxLocalDataSourceとする    

## JSONパーサーについて

https://qiita.com/egugue/items/f1f35c250f7a25768751

GSONが有名ですが、Kotlinとの相性が良くないとのこと。
MoshiだとKotlinをサポートしている。Square製なのでMoshiを採用する

## 設計参考

* メイン
    * https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
* MVVMなど
    * https://github.com/DroidKaigi/conference-app-2017/


## dagger

dagger version 2.12
activityをinjectする方法
https://qiita.com/ryugoo/items/c58fb413882f482f7642
