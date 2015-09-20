lazy val commonSettings = Seq(
  organization := "randonom",
  version := "0.1.0",
  scalaVersion := "2.10.5"
)

// intellij sbt plugin will create new modules for each project instantiated here (based on val name)
lazy val `learning-spark` = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "learning-spark",
    resolvers ++= Seq("confluent" at "http://packages.confluent.io/maven/"),
    libraryDependencies ++= Seq(
      "org.apache.spark" % "spark-core_2.10" % "1.4.1",
      "org.apache.spark" % "spark-streaming_2.10" % "1.4.1",
      "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.4.1",
      "org.apache.avro" % "avro" % "1.7.7",
      "org.apache.kafka" % "kafka-clients" % "0.8.2.2",
      "io.confluent" % "kafka-avro-serializer" % "1.0.1",
      "org.scala-lang.modules" % "scala-java8-compat_2.10" % "0.5.0",
      "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
      "com.typesafe.play" % "play-json_2.10" % "2.4.3",
      "org.reactivemongo" %% "reactivemongo" % "0.11.7",
      "com.typesafe" % "config" % "1.3.0",
      // scalavro is just used for generating avro schema's, can't use lib to it's full effect
      // because I couldn't get it working with Spark
      "com.gensler" %% "scalavro" % "0.6.2" % "test",
      "org.specs2" %% "specs2-core" % "3.6.4" % "test"),

    dependencyOverrides ++= Set(
      // incompatability with jackson dep, favour Spark's verison - http://stackoverflow.com/questions/31039367/spark-parallelize-could-not-find-creator-property-with-name-id
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4",
      // incompatibility between play and reactivemongo versions of netty
      "io.netty" % "netty" % "3.9.9.Final"
    )
  )
