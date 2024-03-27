package Lab1.Util;

import java.util.HashMap;
import java.util.Map;

public class NameGenderDictionary {

    private static final Map<String, String> nameGenderMap = new HashMap<>();

    static {
        nameGenderMap.put("Михаил", "Михайлович");
        nameGenderMap.put("Николай", "Игоревич");
        nameGenderMap.put("Егор", "Алексеевич");
        nameGenderMap.put("Константин", "Васильевич");
        nameGenderMap.put("Олег", "Петрович");
        nameGenderMap.put("Григорий", "Сергеевич");
        nameGenderMap.put("Денис", "Федорович");
        nameGenderMap.put("Станислав", "Анатольевич");
        nameGenderMap.put("Василий", "Дмитриевич");
        nameGenderMap.put("Евгений", "Никитич");
        nameGenderMap.put("Виктор", "Станиславович");
        nameGenderMap.put("Тимофей", "Евгеньевич");
        nameGenderMap.put("Владислав", "Ильич");
        nameGenderMap.put("Пётр", "Романович");
        nameGenderMap.put("Арсений", "Арсенович");
        nameGenderMap.put("Ярослав", "Владимирович");
        nameGenderMap.put("Виталий", "Ярославович");
        nameGenderMap.put("Антон", "Анатольевич");
        nameGenderMap.put("Дмитрий", "Артемович");
        nameGenderMap.put("Александр", "Аркадьевич");
        nameGenderMap.put("Максим", "Иванович");
        nameGenderMap.put("Артем", "Федорович");
        nameGenderMap.put("Алексей", "Тимофеевич");
        nameGenderMap.put("Артур", "Егорович");
        nameGenderMap.put("Владимир", "Константинович");
        nameGenderMap.put("Иван", "Николаевич");
        nameGenderMap.put("Андрей", "Григорьевич");
        nameGenderMap.put("Сергей", "Максимович");
        nameGenderMap.put("Павел", "Павлович");
        nameGenderMap.put("Роман", "Викторович");
        nameGenderMap.put("Георгий", "Олегович");
        nameGenderMap.put("Илья", "Артемович");

        // Добавляем женские имена в словарь
        nameGenderMap.put("Ирина", "Игоревна|female");
        nameGenderMap.put("Екатерина", "Андреевна|female");
        nameGenderMap.put("Ольга", "Владимировна|female");
        nameGenderMap.put("Елена", "Сергеевна|female");
        nameGenderMap.put("Анастасия", "Николаевна|female");
        nameGenderMap.put("Светлана", "Дмитриевна|female");
        nameGenderMap.put("Юлия", "Петровна|female");
        nameGenderMap.put("Наталья", "Александровна|female");
        nameGenderMap.put("Мария", "Ивановна|female");
        nameGenderMap.put("Татьяна", "Артемовна|female");
        nameGenderMap.put("Олеся", "Павловна|female");
        nameGenderMap.put("Евгения", "Арсеньевна|female");
        nameGenderMap.put("Марина", "Викторовна|female");
        nameGenderMap.put("Людмила", "Георгиевна|female");
    }

    public static String getName(String name) {
        return nameGenderMap.getOrDefault(name, null);
    }

    public static Boolean getGender(String name) {
        for (Map.Entry<String, String> entry : nameGenderMap.entrySet()) {
            String checkName = entry.getKey();
            String[] parts = entry.getValue().split("\\|");
            String patronymic = parts[0];
            System.out.println(parts[1]);
            Boolean gender = parts[1].equals("female");
            if(name.equals(checkName)) {
                return gender;
            }
        }
        return false;
    }
}
