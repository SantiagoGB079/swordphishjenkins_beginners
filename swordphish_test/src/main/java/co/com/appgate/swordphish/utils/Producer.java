package co.com.appgate.swordphish.utils;

import co.com.appgate.swordphish.models.RequestMessage;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;

import static co.com.appgate.swordphish.utils.Constants.TOPIC_SALIDA;

public class Producer {

    public static void producerKafka(List<RequestMessage> data, KafkaProducer<String, String> producer,
                                     String topicEntrada) {
        data.get(0).setReplyTo(TOPIC_SALIDA);
        String message = createJson(data);
        ProducerRecord<String, String> record = new ProducerRecord<>(topicEntrada, message);
        producer.send(record);
        producer.flush();
        producer.close();
    }

    public static String createJson(List<RequestMessage> data) {

        Gson gson = new Gson();
        String json = gson.toJson(data);
        json = json.substring(1, json.length() - 1);
        System.out.println(json);

        return json;
    }
}
