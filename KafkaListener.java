package com.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener
{
	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);
	
	/**
	 *  -- ) As of now one method define one consumer instanse here . 
	 *  --)  And all the consumer instance will be inside a  consumer group : listenerGroup1
	 *  --)  We can create multiple consumer instance to increase throughput
	 *  --)  If each partition is assigned to each consumer instance and If new consumer instance will come then he have to sit idle .
	 *  --)  but if producer produces more and more data then  zookeeper will use this consumer instance also to store data.
	 */

	@KafkaListener(topics = "Test-Topic-From-Config2",groupId="listenerGroup2")
	public void consume1(String message) {
		logger.info("Consumer1 consume the message ", message);
	}
	
	@KafkaListener(
	        topics = "Test-Topic-From-Config2",
	        groupId="listenerGroup2",
	        topicPartitions = @TopicPartition(topic = "Test-Topic-From-Config2", partitions = {"0"})
	    )
	public void consume2(String message) {
		logger.info("Consumer2 consume the message ", message);
	}
	@KafkaListener(topics = "Test-Topic-From-Config2",groupId="listenerGroup2")
	public void consume3(String message) {
		logger.info("Consumer3 consume the message ", message);
	}
	@KafkaListener(topics = "Test-Topic-From-Config2",groupId="listenerGroup2")
	public void consume4(String message) {
		logger.info("Consumer4 consume the message ", message);
	}
}
