package com.edureka.listener

import org.apache.spark.scheduler.SparkListener
import org.apache.spark.scheduler.SparkListenerTaskGettingResult
import org.apache.spark.scheduler.SparkListenerBlockManagerRemoved
import org.apache.spark.scheduler.SparkListenerJobEnd
import org.apache.spark.scheduler.SparkListenerEnvironmentUpdate
import org.apache.spark.scheduler.SparkListenerEvent
import org.apache.spark.scheduler.SparkListenerUnpersistRDD
import org.apache.spark.scheduler.SparkListenerTaskEnd
import org.apache.spark.scheduler.SparkListenerApplicationEnd
import org.apache.spark.scheduler.SparkListenerApplicationStart
import org.apache.spark.scheduler.SparkListenerExecutorMetricsUpdate
import org.apache.spark.scheduler.SparkListenerTaskStart
import org.apache.spark.scheduler.SparkListenerExecutorRemoved
import org.apache.spark.scheduler.SparkListenerJobStart
import org.apache.spark.scheduler.SparkListenerStageCompleted
import org.apache.spark.scheduler.SparkListenerBlockUpdated
import org.apache.spark.scheduler.SparkListenerStageSubmitted
import org.apache.spark.scheduler.SparkListenerExecutorAdded
import org.apache.spark.scheduler.SparkListenerBlockManagerAdded
import org.apache.spark.SparkContext
import org.apache.spark.util.JsonProtocolWrapper

import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import com.edureka.producer.ProducerUtil
import org.apache.kafka.clients.producer.KafkaProducer

class MySparkListener extends SparkListener {

  val topic = "BATCH29102018-TOPIC";
  var producer: KafkaProducer[String, String] = null;

  def publishEvent(event: SparkListenerEvent): Unit = {

    var appId = SparkContext.getOrCreate().applicationId;

    var json = JsonProtocolWrapper.sparkEventToJson(event);

    val completeJson = ("timestamp" -> System.currentTimeMillis()) ~
      ("application-id" -> appId) ~
      ("spark-event" -> json)

    val publishJson = compact(render(completeJson));

    producer = ProducerUtil.getProducer();

    ProducerUtil.send(producer, topic, appId, publishJson.toString());

  }

  override def onStageCompleted(stageCompleted: SparkListenerStageCompleted): Unit = {}

  override def onStageSubmitted(stageSubmitted: SparkListenerStageSubmitted): Unit = {}

  override def onTaskStart(taskStart: SparkListenerTaskStart): Unit = {}

  override def onTaskGettingResult(taskGettingResult: SparkListenerTaskGettingResult): Unit = {}

  override def onTaskEnd(taskEnd: SparkListenerTaskEnd): Unit = {}

  override def onJobStart(jobStart: SparkListenerJobStart): Unit = {
    publishEvent(jobStart)
  }

  override def onJobEnd(jobEnd: SparkListenerJobEnd): Unit = {
    publishEvent(jobEnd)
  }

  override def onEnvironmentUpdate(environmentUpdate: SparkListenerEnvironmentUpdate): Unit = {}

  override def onBlockManagerAdded(blockManagerAdded: SparkListenerBlockManagerAdded): Unit = {}

  override def onBlockManagerRemoved(
    blockManagerRemoved: SparkListenerBlockManagerRemoved): Unit = {}

  override def onUnpersistRDD(unpersistRDD: SparkListenerUnpersistRDD): Unit = {}

  override def onApplicationStart(applicationStart: SparkListenerApplicationStart): Unit = {
    publishEvent(applicationStart);
  }

  override def onApplicationEnd(applicationEnd: SparkListenerApplicationEnd): Unit = {
    publishEvent(applicationEnd);
  }

  override def onExecutorMetricsUpdate(
    executorMetricsUpdate: SparkListenerExecutorMetricsUpdate): Unit = {}

  override def onExecutorAdded(executorAdded: SparkListenerExecutorAdded): Unit = {}

  override def onExecutorRemoved(executorRemoved: SparkListenerExecutorRemoved): Unit = {}

  override def onBlockUpdated(blockUpdated: SparkListenerBlockUpdated): Unit = {}

  override def onOtherEvent(event: SparkListenerEvent): Unit = {}

}