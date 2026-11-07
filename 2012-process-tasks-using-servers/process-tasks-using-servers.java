class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // availableServers stores servers as int[]: {weight, index}
        PriorityQueue<int[]> availableServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // busyServers stores servers as int[]: {releaseTime, weight, index}
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        // Initially all servers are available
        for (int i = 0; i < servers.length; i++) {
            availableServers.offer(new int[]{servers[i], i});
        }

        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        long time = 0;

        for (int j = 0; j < m; j++) {
            time = Math.max(time, j);

            // If no servers are available, jump time to when the next server becomes free
            if (availableServers.isEmpty() && !busyServers.isEmpty()) {
                time = Math.max(time, busyServers.peek()[0]);
            }

            // Free up all servers that have finished their tasks by the current time
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                int[] freed = busyServers.poll();
                availableServers.offer(new int[]{freed[1], freed[2]});
            }

            // Assign the task to the best available server
            int[] server = availableServers.poll();
            int weight = server[0];
            int index = server[1];

            ans[j] = index;
            busyServers.offer(new int[]{(int) time + tasks[j], weight, index});
        }

        return ans;
    }
}