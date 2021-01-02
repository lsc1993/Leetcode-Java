package com.ls.leetcode.question;

import java.util.concurrent.*;

/**
 * 生产者消费者模式
 *
 * @author liushuanggo@gmail.com
 * @since 2021-01-02
 */
public class ProductAndCustom {

    private static BlockingQueue<Message> messageQueue = new ArrayBlockingQueue<>(1000, true);

    public static void main(String[] args) {
        new Product().start();
        new Customer().customMessage();
    }

    static class Product extends Thread {
        private int messageCount = 0;
        @Override
        public void run() {
            requestMessage();

            while (messageCount < 30) {
                requestMessageDelay(2000L);
            }

        }

        private void requestMessage() {
            Message message;
            for (int i = 0; i < 10; ++i) {
                message = new Message();
                message.setMsg("message at " + System.currentTimeMillis());
                message.setTime(System.currentTimeMillis());
                messageQueue.offer(message);
            }
        }

        private void requestMessageDelay(long delay) {
            Message message = new Message();
            message.setMsg("message at " + System.currentTimeMillis());
            message.setTime(System.currentTimeMillis());
            messageQueue.offer(message);
            System.out.println("+++++++++++++++生产了消息: " + message.toString() + "++++++++++++++++");
            messageCount ++;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Customer {
        private ThreadPoolExecutor threadPool;

        public Customer() {
            int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
            threadPool = new ThreadPoolExecutor(corePoolSize, corePoolSize, 101, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000));
        }

        public void customMessage() {
            while (true) {
                try {
                    Message message = messageQueue.poll(5, TimeUnit.SECONDS);
                    if (message == null) {
                        System.out.println("message is null! 退出程序~~~");
                        break;
                    }
                    threadPool.submit(() -> {
                        System.out.println("=============消费了消息: " + message.toString() + "=================");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Message {
        private String msg;
        private long time;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "msg='" + msg + '\'' +
                    ", time=" + time +
                    '}';
        }
    }
}
