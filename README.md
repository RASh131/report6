# ゲーム<ヌメロン>を再現  
## 以下ルール説明  
数字を求められたら重複しない三桁の数字を半角で入力してください。 
1. プレイヤーとNPCの1対1  
2. プレイヤー二人は0~9の数字の中から重複しない3つ数字を決める  
3. 先行、後攻を決めお互いに3つの数字を予想しあう  
4. 予想した数字が相手の決めた数字の中に含まれていた時はBITE  
   数字が含まれている上に宣言した場所まであっていた時はEAT
5. 先に3EATしたプレイヤーが勝ち  
 
## GameMasterクラス  
### フィールド変数
- enem_num  
    - int型配列を使用
    - enemyの数字を格納する
- self_num  
    - int型配列を使用
    - プレイヤーの数字を格納する
- name
    - String型を使用
    - ターンプレイヤーの名前を格納する  

### メソッド
- コンストラクタ
    - 受け取ったenem_numとself_numをフィールドに格納する
- start
    - 相手の数字を予想させる、もしくはNPCがランダムに数字を予想する
- numberCheck
    -  予想の数字がEAT、もしくはBITEしているか判定する
- getName
    - ターンプレイヤーの名前を取得する
- waitMoment
    - 一定時間の遅延を発生させる

## Numbersクラス
### フィールド変数
- numbers
    - int型配列を使用
    - 数字を格納する
- name
    - String型を使用
    - playerもしくはenemyを格納する
### メソッド
- 引数なしコンストラクタ
    - 乱数を格納する
- 引数ありコンストラクタ
    - 引数がplayerのときは数字を入力し格納させ、enemyの時は乱数を格納する
- getNumber
    - 格納された数字を取得する
- randNumber
    - 乱数を生成して格納する
    
## Mainクラス
### フィールド変数 
- なし 
### メソッド  
- main(String[] args)
    - ゲームの実行をする
