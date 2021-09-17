package com.adam;

public class Main {

	public static void test1() {

		Trie<Integer> trie = new Trie<>();
		trie.add("cat", 1);
		trie.add("dog", 2);
		trie.add("catalog", 3);
		trie.add("cast", 4);
		trie.add("小马哥", 5);
		Asserts.test(trie.size() == 5);
		Asserts.test(trie.startsWith("c"));
		Asserts.test(trie.startsWith("ca"));
		Asserts.test(trie.startsWith("cat"));
		Asserts.test(trie.startsWith("cata"));
		Asserts.test(!trie.contains("cata"));
		Asserts.test(!trie.startsWith("haha"));
		Asserts.test(trie.get("小马哥") == 5);
		Asserts.test(trie.remove("cat") == 1);
		Asserts.test(trie.remove("catalog") == 3);
		Asserts.test(trie.remove("cast") == 4);
		Asserts.test(trie.size() == 2);
		Asserts.test(trie.startsWith("do"));
		Asserts.test(!trie.startsWith("c"));
		System.out.println("测试通过");
	}

	public static void main(String[] args) {
		test1();
	}

}
