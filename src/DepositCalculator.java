import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return getRoundNumber(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRoundNumber(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRoundNumber(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    void getDepositMenu() {
        int depositPeriod;
        int depositType;
        double outVar = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            outVar = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            outVar = calculateComplexPercent(amount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + outVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().getDepositMenu();
    }
}
