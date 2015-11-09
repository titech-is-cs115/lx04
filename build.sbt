// 重要な注意：各設定の間に必ず空行を挿入して下さい。これをしないと sbt が起動しません。

name := "cs1.lx04"      // プロジェクトの名称

version := "0.1.0"       // プロジェクトのバージョン番号

scalaVersion := "2.11.7" // コンパイルに使う scalac のバージョン

scalacOptions ++=        // scalac に与えるオプション
  Seq("-optimize",
    "-feature",
    "-unchecked",
    "-deprecation")

javaOptions in run ++=   // 仮想機械に与えるオプション
  Seq( "-Xmx2G", "-verbose:gc")                          

// sbt の挙動の設定

fork := true

connectInput := true

// ソースコードの在処を非標準の場所に設定

scalaSource in Compile := baseDirectory.value / "src"

// コンパイル結果を非標準の場所に設定

target := Path.userHome / "tmp" / "cs1f" / "lx05"
