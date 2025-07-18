# [Silver II] Dancing With the Googlers (Small) - 12401 

[문제 링크](https://www.acmicpc.net/problem/12401) 

### 성능 요약

메모리: 16068 KB, 시간: 124 ms

### 분류

구현, 수학

### 제출 일자

2025년 7월 18일 16:55:24

### 문제 설명

<p>You're watching a show where Googlers (employees of Google) dance, and then each dancer is given a <em>triplet of scores</em> by three judges. Each triplet of scores consists of three integer scores from 0 to 10 inclusive. The judges have very similar standards, so it's <em>surprising</em> if a triplet of scores contains two scores that are 2 apart. No triplet of scores contains scores that are more than 2 apart.</p>

<p>For example: (8, 8, 8) and (7, 8, 7) are not surprising. (6, 7, 8) and (6, 8, 8) are surprising. (7, 6, 9) will never happen.</p>

<p>The <em>total points</em> for a Googler is the sum of the three scores in that Googler's triplet of scores. The <em>best result</em> for a Googler is the maximum of the three scores in that Googler's triplet of scores. Given the total points for each Googler, as well as the number of surprising triplets of scores, what is the maximum number of Googlers that could have had a best result of at least <strong>p</strong>?</p>

<p>For example, suppose there were 6 Googlers, and they had the following total points: <code>29, 20, 8, 18, 18, 21</code>. You remember that there were 2 surprising triplets of scores, and you want to know how many Googlers could have gotten a best result of 8 or better.</p>

<p>With those total points, and knowing that two of the triplets were surprising, the triplets of scores could have been:</p>

<pre>10 9 10
6 6 8 (*)
2 3 3
6 6 6
6 6 6
6 7 8 (*)
</pre>

<p>The cases marked with a (*) are the surprising cases. This gives us 3 Googlers who got at least one score of 8 or better. There's no series of triplets of scores that would give us a higher number than 3, so the answer is 3.</p>

### 입력 

 <p>The first line of the input gives the number of test cases, <strong>T</strong>.  <strong>T</strong> test cases follow. Each test case consists of a single line containing integers separated by single spaces. The first integer will be <strong>N</strong>, the number of Googlers, and the second integer will be <strong>S</strong>, the number of surprising triplets of scores. The third integer will be <strong>p</strong>, as described above. Next will be <strong>N</strong>integers <strong>t<sub>i</sub></strong>: the total points of the Googlers.</p>

<h3>Limits</h3>

<ul>
	<li>1 ≤ <strong>T</strong> ≤ 100.</li>
	<li>0 ≤ <strong>S</strong> ≤ N.</li>
	<li>0 ≤ <strong>p</strong> ≤ 10.</li>
	<li>0 ≤ <strong>t<sub>i</sub></strong> ≤ 30.</li>
	<li>At least <strong>S</strong> of the <strong>t<sub>i</sub></strong> values will be between 2 and 28, inclusive.</li>
	<li>1 ≤ <strong>N</strong> ≤ 3.</li>
</ul>

### 출력 

 <p>For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is the maximum number of Googlers who could have had a best result of greater than or equal to <strong>p</strong>.</p>

