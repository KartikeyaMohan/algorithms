import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Leetcode 841
 * There are n rooms labeled from 0 to n - 1 and all the
 * rooms are locked except for room 0. Your goal is to
 * visit all the rooms. However, you cannot enter a
 * locked room without having its key.
 * When you visit a room, you may find a set of distinct
 * keys in it. Each key has a number on it, denoting
 * which room it unlocks, and you can take all of them
 * with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of
 * keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false
 * otherwise.
 */
class KeysAndRooms {

    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];
        Set<Integer> keys = new HashSet<>();
        stack.add(0);
        visited[0] = true;
        keys.add(0);
        while (!stack.isEmpty()) {
            int room = stack.pop();
            for(int i = 0; i < rooms.get(room).size(); i++) {
                keys.add(rooms.get(room).get(i));
                if (!visited[rooms.get(room).get(i)]) {
                    visited[rooms.get(room).get(i)] = true;
                    stack.add(rooms.get(room).get(i));
                }
            }
        }
        return keys.size() == rooms.size();
    }

    public static void main(String[] args) {
        KeysAndRooms object = new KeysAndRooms();
        List<List<Integer>> rooms = List.of(
                List.of(6, 7, 8),
                List.of(5, 4, 9),
                List.of(),
                List.of(8),
                List.of(4),
                List.of(),
                List.of(1, 9, 2, 3),
                List.of(7),
                List.of(6, 5),
                List.of(2, 3, 1)
        );
        System.out.println(object.canVisitAllRooms(rooms));
    }
}