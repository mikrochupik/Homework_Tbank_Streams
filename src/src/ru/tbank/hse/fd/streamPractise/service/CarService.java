package ru.tbank.hse.fd.streamPractise.service;

import ru.tbank.hse.fd.streamPractise.model.Car;
import ru.tbank.hse.fd.streamPractise.model.CarInfo;
import ru.tbank.hse.fd.streamPractise.model.Owner;
import ru.tbank.hse.fd.streamPractise.utils.Condition;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Необходимо реализовать каждый метод
 * <p>
 * Запрещено использовать if, for, foreach...
 * Все методы реализуются в одну строчку
 * Можно использовать только stream API
 *
 */
public class CarService {

    /**
     * Приходит список Car
     * Необходимо вернуть список строк из Condition
     */
    public List<Condition> getConditions(List<Car> cars) {
        return cars.stream()
                .map(Car::getCondition)
                .collect(Collectors.toList());
    }

    /**
     * Приходит список Car
     * Необходимо вернуть только те, у которых Condition - "NEW"
     */
    public List<Car> getNewCars(List<Car> cars) {
        return cars.stream()
                .filter(Car -> Car.getCondition().equals("NEW"))
                .collect(Collectors.toList());
    }

    /**
     * Приходит список Car
     * Необходимо вернуть количество Car, у которых больше 2 Owners
     */
    public long countCarsOwners(List<Car> cars) {
        return cars.stream()
                .filter(Car -> Car.getOwners() > 2)
                .count();
    }

    /**
     * Приходит список Car
     * Необходимо каждому элементу списка в поле age прибавить 1
     */
    public List<Car> incrementCarAge(List<Car> cars) {
        return cars.stream()
                .peek(Car -> Car.setAge(Car.getAge() + 1))
                .collect(Collectors.toList());
    }

    /**
     * Приходит список Car
     * Необходимо вернуть Car, у которого самое большое значение age
     */
    public Optional<Car> getOldestCar(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getAge));

    }

    /**
     * Приходит список Car
     * Необходимо вернуть список имён всех владельцев
     * Имена не должны повторяться
     */
    public List<List<Owner>> getOwnersCarsNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getOwners)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Приходит список Car
     * Необходимо преобразовать его в список CarInfo
     */
    public List<CarInfo> mapToCarInfo(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть не более двух машин, у которых Condition - BROKEN
     */
    public List<Car> getTwoBrokenCar(List<Car> cars) {
        return cars.stream()
                .filter(Car -> Car.getCondition().equals("BROKEN"))
                .limit(2)
                .collect(Collectors.toList());
    }

    /**
     * Приходит список Car
     * Необходимо вернуть отсортированный по полю age список Car
     */
    public List<Car> getSortedCarsByAge(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо посчитать средний возраст всех машин
     */
    public double getAvgCarsAge(List<Car> cars) {
        return cars.stream()
                .map(Car::getAge)
                .average();
    }

    /**
     * Приходит список Car
     * Проверить, что все машины с Condition - "Broken" старше 10 лет
     */
    public Boolean checkBrokenCarsAge(List<Car> cars) {
        return cars.stream()
                .filter(Car -> Car.getCondition().equals("BROKEN"))
                .allMatch(Car -> Car.getAge() > 10);
    }

    /**
     * Приходит список Car
     * Проверить, что хотя бы у одной машины с Condition - "USED" был владелец по имени Adam
     */
    public Boolean checkCarOwnerName(List<Car> cars) {
        return cars.stream()
                .filter(Car -> Car.getCondition().equals("USED"))
                .anyMatch(Car -> Car.getOwners().contains("Adam"));
    }

    /**
     * Приходит список Car
     * Необходимо вернуть любого Owner старше 36 лет
     */
    public Optional<Owner> getAnyOwner(List<Car> cars) {
        return cars.stream()
                .flatMap(Car -> Car.getOwners().stream())
                .filter(owner -> owner.getAge() > 36)
                .findFirst();
    }
}
