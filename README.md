## コード構造

コントローラーパス:
`todo_java/src/main/java/todolist/controllers/`

モデルパス:
`todo_java/src/main/java/todolist/models/`

ビューパス:
`todo_java/src/main/resources/templates/`

### 画面
- home (トップ画面)
- edit (編集画面)
- search (検索画面)

画面ごとにそれぞれのコントローラーとビューがあります。

### モデル
- TodoItem (Todoアイテムの情報を持つモデル)
- SearchText (検索画面のテキストフィールドの文字列をフォームからコントローラーに送られるようなモデル)

---

## 開発環境のセットアップ

必要なソフトウェア:
- Java
- MySql
- gradle


DBとDBのユーザーの作成：

```shell
mysql> create database db_todo_list;
mysql> grant all on db_todo_list.* to 'todouser'@'%' identified by 'password';

```

プロジェクトを実行する方法：
```shell
todo_java/ $ gradle build
todo_java/ $ java -jar build/libs/java_todo-0.0.1-SNAPSHOT.jar

or

todo_java/ $ gradle bootRun
```