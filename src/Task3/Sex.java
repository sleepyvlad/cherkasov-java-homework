package Task3;
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