
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