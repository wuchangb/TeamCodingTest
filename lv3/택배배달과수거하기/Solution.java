package programmers.lv3.택배배달과수거하기;

import java.util.PriorityQueue;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int sumD = 0;
        int sumP = 0;
        PriorityQueue<Del> pqD = new PriorityQueue<>();
        PriorityQueue<Pic> pqP = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] == 0 && pickups[i] == 0) continue;
            if (deliveries[i] != 0) {
                pqD.add(new Del(deliveries[i], i + 1));
                sumD += deliveries[i];
            }
            if (pickups[i] != 0) {
                pqP.add(new Pic(pickups[i], i + 1));
                sumP += pickups[i];
            }
        }

        while (sumD > 0 || sumP > 0) {
            //배달, 픽업 둘다 남은경우
            if (!pqD.isEmpty() && !pqP.isEmpty()) {
                if (pqD.peek().dist >= pqP.peek().dist) {
                    int cnt = Math.min(sumD, cap);  //처음 들고갈 물건개수
                    sumD -= cnt;
                    answer += pqD.peek().dist * 2;
                    while (cnt > 0) {
                        Del now = pqD.peek();
                        if (cnt >= now.count) {
                            cnt -= now.count;
                            pqD.poll();
                        } else {
                            now.count -= cnt;
                            cnt = 0;
                        }
                    }
                    cnt = Math.min(sumP, cap);  //픽업할 수 있는 최대물건
                    sumP -= cnt;
                    while (cnt > 0) {
                        Pic now = pqP.peek();
                        if (cnt >= now.count) {
                            cnt -= now.count;
                            pqP.poll();
                        } else {
                            now.count -= cnt;
                            cnt = 0;
                        }
                    }
                } else {
                    int cnt = Math.min(sumP, cap);
                    sumP -= cnt;
                    answer += pqP.peek().dist * 2;
                    while (cnt > 0) {
                        Pic now = pqP.peek();
                        if (cnt >= now.count) {
                            cnt -= now.count;
                            pqP.poll();
                        } else {
                            now.count -= cnt;
                            cnt = 0;
                        }
                    }
                    cnt = Math.min(sumD, cap);
                    sumD -= cnt;
                    while (cnt > 0) {
                        Del now = pqD.peek();
                        if (cnt >= now.count) {
                            cnt -= now.count;
                            pqD.poll();
                        } else {
                            now.count -= cnt;
                            cnt = 0;
                        }
                    }
                }

            } else if (!pqD.isEmpty() && pqP.isEmpty()){    //배달만 남은경우
                int cnt = Math.min(sumD, cap);
                sumD -= cnt;
                answer += pqD.peek().dist * 2;
                while (cnt > 0) {
                    Del now = pqD.peek();
                    if (cnt >= now.count) {
                        cnt -= now.count;
                        pqD.poll();
                    } else {
                        now.count -= cnt;
                        cnt = 0;
                    }
                }

            } else if (!pqP.isEmpty() && pqD.isEmpty()) {   //픽업만 남은경우
                int cnt = Math.min(sumP, cap);
                sumP -= cnt;
                answer += pqP.peek().dist * 2;
                while (cnt > 0) {
                    Pic now = pqP.peek();
                    if (cnt >= now.count) {
                        cnt -= now.count;
                        pqP.poll();
                    } else {
                        now.count -= cnt;
                        cnt = 0;
                    }
                }
            }

        }

        return answer;
    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int cap = 4;
//        int n = 5;
//        int[] delivery = {1, 0, 3, 1, 2};
//        int[] pickups = {0, 3, 0, 4, 0};
//        System.out.println(sol.solution(cap,n,delivery,pickups));
//
//    }

    class Del implements Comparable<Del> {
        int count;
        int dist;

        public Del(int count, int dist) {
            this.count = count;
            this.dist = dist;
        }

        @Override
        public int compareTo(Del o) {
            return o.dist-this.dist;
        }
    }

    class Pic implements Comparable<Pic> {
        int count;
        int dist;

        public Pic(int count, int dist) {
            this.count = count;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pic o) {
            return o.dist-this.dist;
        }
    }
}