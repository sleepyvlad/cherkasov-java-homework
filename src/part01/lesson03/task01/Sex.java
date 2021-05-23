package part01.lesson03.task01;
/*
    Класс пола который хранит поле sex(пол) и может выбросить
    исключение UnknownSexException, если неправильно введён пол

* */
public class Sex {
    private String sex;

    public void setSex(String sex) throws UnknownSexException {
        try {
            if(!sex.equals("MAN") && !sex.equals("WOMAN")) {
                throw new UnknownSexException("Unknown sex", sex);
            }
            this.sex = sex;
        } catch (UnknownSexException e) {
            System.out.println("Input WOMAN OR MAN");
            throw e;
        }
        this.sex = sex;
    }
    public String getSex() {
        return this.sex;
    }

    public Sex() {
        this.sex = "MAN";
    }

    public Sex(String sex) throws UnknownSexException{
        try {
            if(!sex.equals("MAN") && !sex.equals("WOMAN")) {
                throw new UnknownSexException("Unknown sex", sex);
            }
            this.sex = sex;
        } catch (UnknownSexException e) {
            System.out.println("Input WOMAN OR MAN");
            throw e;
        }
    }

    public int compareTo(Sex otherSex) {
        if (this.sex.equals(otherSex.getSex())) {
           return 0;
        } else if(this.sex.equals("MAN") && otherSex.getSex().equals("WOMAN")) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Sex{" +
                "sex='" + sex + '\'' +
                '}';
    }
}

/*
    Класс исключения "неизвестный пол"
* */

class UnknownSexException extends Exception{
    private String sex;

    public String getSex() {
        return sex;
    }

    public UnknownSexException(String message, String unknownSex) {
        super(message);
        sex = unknownSex;
    }
}