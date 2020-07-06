package ru.molchanov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Converter {
    private Integer firstSystem;
    private Integer secondSystem;
    private String numToConvert;
    private String result;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        while (true){
            convert();
            if(startAgain()){
                firstSystem = secondSystem = null;
                numToConvert = result = null;
            }
            else{
                try{
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    private boolean startAgain() {
        while (true) {
            try {
                System.out.print("\nПродолжить?\n Y/N: ");
                String restart = reader.readLine().trim().toLowerCase();
                if (restart.equals("y")) {
                    firstSystem = secondSystem = null;
                    numToConvert = result = null;
                    return true;
                }
                if (restart.equals("n")) {
                    System.out.println("Завершение работы приложения.");
                    return false;
                } else {
                    throw new IOException("Некорректный ввод.");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getInputForFirstSystem() throws IOException{
        if(firstSystem == null) {
            System.out.print("Введите систему счисления вашего числа: ");
            try {
                firstSystem = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                firstSystem = null;
                throw new IOException("Некорректный ввод.");
            }
            if (firstSystem < 2 || firstSystem > 36) {
                firstSystem = null;
                throw new IOException("Некорректное число.");
            }
        }
    }

    private void getInputForSecondSystem() throws IOException{
        if(secondSystem == null) {
            System.out.print("Введите систему счисления для конвертации: ");
            try {
                secondSystem = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                secondSystem = null;
                throw new IOException("Некорректный ввод.");
            }
            if (secondSystem < 2 || secondSystem > 36) {
                secondSystem = null;
                throw new IOException("Некорректное число.");
            }
        }
    }

    private void getInputForNumToConvert() throws IOException {
        if(numToConvert == null){
            System.out.print("Введите ваше число: ");
            numToConvert = reader.readLine();
            if(numToConvert.isEmpty()){
                numToConvert = null;
                throw new IOException("Некорректное число.");
            }
            if(!checkNumToConvert()){
                numToConvert = null;
                throw new IOException("Введенное число не соответствует системе счисления.");
            }
        }
    }

    private void getInput(){
        boolean isAllParametersCorrect = false;
        while(!isAllParametersCorrect){
            try {
                getInputForFirstSystem();
                getInputForSecondSystem();
                getInputForNumToConvert();
                isAllParametersCorrect = true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void convert(){
        getInput();
        result = new BigInteger(numToConvert, firstSystem).toString(secondSystem);
        System.out.println("Результат: " + result);
    }

    private boolean checkNumToConvert(){
        try{
            new BigInteger(numToConvert, firstSystem);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer getFirstSystem() {
        return firstSystem;
    }

    public void setFirstSystem(Integer firstSystem) {
        this.firstSystem = firstSystem;
    }

    public Integer getSecondSystem() {
        return secondSystem;
    }

    public void setSecondSystem(Integer secondSystem) {
        this.secondSystem = secondSystem;
    }

    public String getNumToConvert() {
        return numToConvert;
    }

    public void setNumToConvert(String numToConvert) {
        this.numToConvert = numToConvert;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
