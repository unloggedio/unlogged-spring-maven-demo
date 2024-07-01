//package org.unlogged.demo.controller;
//
//import io.opentelemetry.context.Context;
//import io.opentelemetry.sdk.common.CompletableResultCode;
//import io.opentelemetry.sdk.trace.ReadWriteSpan;
//import io.opentelemetry.sdk.trace.ReadableSpan;
//import io.opentelemetry.sdk.trace.SpanProcessor;
//
//public class CustomSpanProcessor implements SpanProcessor {
//    @Override
//    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
//        System.out.println("start label");
//    }
//
//    @Override
//    public boolean isStartRequired() {
//        return false;
//    }
//
//    @Override
//    public void onEnd(ReadableSpan readableSpan) {
//        System.out.println("label end");
//    }
//
//    @Override
//    public boolean isEndRequired() {
//        return false;
//    }
//
//    @Override
//    public CompletableResultCode shutdown() {
//        return SpanProcessor.super.shutdown();
//    }
//
//    @Override
//    public CompletableResultCode forceFlush() {
//        return SpanProcessor.super.forceFlush();
//    }
//
//    @Override
//    public void close() {
//        SpanProcessor.super.close();
//    }
//}
