package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable createException(Enum exceptionEnum) {
        if (exceptionEnum != null) {
            String resultMessage = String.format("%s%s",
                    exceptionEnum.toString().substring(0, 1),
                    exceptionEnum.toString().toLowerCase().replaceAll("_", " ").substring(1)
            );
            if (exceptionEnum instanceof ApplicationExceptionMessage) {
                return new Exception(resultMessage);
            } else if (exceptionEnum instanceof DatabaseExceptionMessage) {
                return new RuntimeException(resultMessage);
            } else if (exceptionEnum instanceof UserExceptionMessage) {
                return new Error(resultMessage);
            }
        }
        return new IllegalArgumentException();
    }
}
