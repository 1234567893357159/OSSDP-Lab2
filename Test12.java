import java.math.BigInteger;
import java.util.Random;

public class Test12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Random random = new Random();
        int total = 10;
        int passed = 0;

        // 循环执行10次随机测试
        for (int i = 0; i < total; i++) {
            // 随机生成两个非负整数字符串（长度1-10位）
            String num1 = generateRandomNumberString(random, 1, 10);
            String num2 = generateRandomNumberString(random, 1, 10);

            // 计算程序结果
            String result = solution.multiply(num1, num2);

            // 计算预期结果（使用BigInteger验证）
            BigInteger expectedBig = new BigInteger(num1).multiply(new BigInteger(num2));
            String expected = expectedBig.toString();

            // 验证并输出结果
            System.out.println("测试用例" + (i + 1) + ":");
            System.out.println("  输入: num1 = \"" + num1 + "\", num2 = \"" + num2 + "\"");
            System.out.println("  预期: " + expected);
            System.out.println("  实际: " + result);

            if (result.equals(expected)) {
                passed++;
                System.out.println("  结果: 成功");
            } else {
                System.out.println("  结果: 失败");
            }
            System.out.println();
        }

        // 测试总结
        System.out.println("测试总结: 共 " + total + " 个用例，成功 " + passed + " 个，失败 " + (total - passed) + " 个");
    }

    /**
     * 生成随机非负整数字符串
     * @param random 随机数生成器
     * @param minLen 最小长度（含）
     * @param maxLen 最大长度（含）
     * @return 随机非负整数字符串（不会有前导零，除非数字本身是0）
     */
    private static String generateRandomNumberString(Random random, int minLen, int maxLen) {
        // 随机生成长度
        int length = minLen + random.nextInt(maxLen - minLen + 1);

        // 特殊情况：生成"0"
        if (random.nextDouble() < 0.1) { // 10%概率生成0
            return "0";
        }

        // 生成首位数字（1-9，避免前导零）
        StringBuilder sb = new StringBuilder();
        int firstDigit = 1 + random.nextInt(9);
        sb.append(firstDigit);

        // 生成其余数字（0-9）
        for (int i = 1; i < length; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }
}