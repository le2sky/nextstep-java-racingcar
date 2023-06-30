package racingcargamev2.domain;

public class Car {

    private static final int MIN_CONDITION_RANGE = 0;
    private static final int MAX_CONDITION_RANGE = 9;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = Position.zero();
    }

    public void move(int condition) {
        checkMoveConditionRange(condition);

        if (condition >= 4) {
            position.increase();
        }
    }

    private void checkMoveConditionRange(int condition) {
        if (isMoveConditionInRange(condition)) {
            throw new IllegalArgumentException("전진에 필요한 숫자는 0에서 9사이의 숫자입니다.");
        }
    }

    private boolean isMoveConditionInRange(int condition) {
        return condition < MIN_CONDITION_RANGE || condition > MAX_CONDITION_RANGE;
    }

    public Position getPosition() {
        return position;
    }
}
