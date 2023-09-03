import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    @Test
    public void customizingTheCurrentStation() {                 //Пользовательская настройка текущей станции.
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        int expected = 15;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextRadioStation() {                       //Переход на следующую радиостанцию.
        Radio radio = new Radio(20);
        radio.setCurrentStation(17);
        radio.next();
        int expected = 18;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void previousRadioStation() {                        //Переход на предыдущую радиостанцию.
        Radio radio = new Radio(20);
        radio.setCurrentStation(17);
        radio.prev();
        int expected = 16;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void jumpForwardTo0After9() {          //Переход вперед к 0 после 19.
        Radio radio = new Radio(20);
        radio.setCurrentStation(19);
        radio.next();
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void GoBackTo9After0() {                //Вернуться к 19 после 0.
        Radio radio = new Radio(20);
        radio.setCurrentStation(0);
        radio.prev();
        int expected = 19;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void stationShouldNotBeMoreThan10() {            //Радиостанци не должна быть больше чем 10.
        Radio radio = new Radio(20);
        radio.setCurrentStation(21);
        radio.next();
        int expected = 1;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void stationMustNotBeBelow0() {               //Радиостанций не должна быть ниже 0.
        Radio radio = new Radio(20);
        radio.setCurrentStation(-1);
        radio.prev();
        int expected = 19;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseSoundVolume() {                  //Увеличить уровень громкости звука.
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnDownTheSoundVolume() {                //Уменьшить уровень громкости звука.
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.decreaseVolume();
        int expected = 99;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void theMaximumVolumeOfSound() {                   //Максимальный объём звука.
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void minimumVolumeOfSound() {                 //Минимальный обьём звука.
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void theSoundChouldNotDeMoreThan100() {        //Звук не должен быть более 100.
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void soundMustNotDeDelow0() {      //Звук не должен быть ниже 0.
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}