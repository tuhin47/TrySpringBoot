package com.tuhin.springboot.programming;

import com.squareup.okhttp.*;
import lombok.SneakyThrows;

public class MySchedular {

    public static void main(String[] args) {
        RunProgram.runScript();
        /*ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Dhaka"));
        System.err.println("Start");
        ZonedDateTime nextRun = now.withHour(23).withMinute(20).withSecond(20);
        if(now.compareTo(nextRun) > 0)
            nextRun = nextRun.plusDays(1);

        Duration duration = Duration.between(now, nextRun);
        long initalDelay = duration.getSeconds();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new RunProgram(),
                initalDelay,
                TimeUnit.DAYS.toSeconds(1),
                TimeUnit.SECONDS);*/
    }


}

class RunProgram extends Thread {


    public void run() {
        System.err.println("Starting .... ");
        runScript();
        System.err.println("Done");
    }

    @SneakyThrows
    public static void runScript() {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "csrfPreventionSalt=Vhel6fSi5WCqfYxKXjA6&password=hello&username=bbank");
        Request request = new Request.Builder()
                .url("http://localhost:8080/btcl/Login.do")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
    }
}
