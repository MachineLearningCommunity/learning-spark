#!/bin/sh
SPARK_HOME=~/spark-1.4.1-bin-hadoop2.6

SCRIPT=$(readlink -f "$0")
SCRIPTPATH=$(dirname "$SCRIPT")

LS_HOME=$SCRIPTPATH/../

(cd $LS_HOME; sbt package)

$SPARK_HOME/bin/spark-shell --jars $LS_HOME/target/scala-2.10/learning-spark_2.10-0.1.0.jar
