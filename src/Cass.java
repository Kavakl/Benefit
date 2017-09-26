public class Cass {
    public class Res {

        int leftIndex;
        int rightIndex;
        int sum;

        public Res(int leftIndex, int rightIndex, int sum) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.sum = sum;
        }
    }

    public int[] deltaP(int arr[]) {
        int[] delta = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            delta[i] = arr[i + 1] - arr[i];
        }
        return delta;
    }

    public Res max(int[] arr, int bot, int top) {
        if (bot == top) {
            return new Res(bot, top, arr[bot]);
        } else {
            int mid = (bot + top) / 2;
            Res left = max(arr, bot, mid);
            Res right = max(arr, mid +1, top);
            Res cross = maxP(arr, bot, mid, top);
            if (right.sum == left.sum && right.sum >= cross.sum) {
                return new Res(0, 0, 0);
            } else if (left.sum >= right.sum && left.sum >= cross.sum) {
                return new Res(left.leftIndex, left.rightIndex, left.sum);
            }else if (right.sum >= left.sum && right.sum == cross.sum) {
                return new Res(right.leftIndex, right.rightIndex+1, right.sum);
            }
            else if (right.sum >= left.sum && right.sum >= cross.sum) {
                return new Res(right.leftIndex, right.rightIndex, right.sum);
            } else {
                return new Res(cross.leftIndex, cross.rightIndex+1, cross.sum);
            }
        }
    }

    public Res maxP(int[] arr, int bot, int mid, int top) {

        int currentLeft = Integer.MIN_VALUE;
        int currentRight = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        for (int i = mid; i >= bot; i--) {
            sum += arr[i];
            if (sum > currentLeft) {
                currentLeft = sum;
                left = i;
                right = 0;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= top; j++) {
            sum += arr[j];
            if (sum > currentRight) {
                currentRight = sum;
                right = j;
            }
        }
        return new Res(left, right, currentLeft + currentRight);
    }
}
