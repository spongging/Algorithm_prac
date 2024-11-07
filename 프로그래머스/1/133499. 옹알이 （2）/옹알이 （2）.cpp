#include <string>
#include <vector>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0;

    // 가능한 발음 목록
    vector<string> valid_sounds = {"aya", "ye", "woo", "ma"};

    for (const string& word : babbling) {
        bool is_valid = true;  // 단어가 발음 가능한지 여부
        string last_word = "";  // 직전 발음
        int i = 0;              // 현재 위치를 나타내는 인덱스

        while (i < word.size()) {
            bool found = false;

            // 가능한 발음 중 하나와 매칭되는지 확인
            for (const string& sound : valid_sounds) {
                // 단어가 현재 위치에서 발음 가능하고, 연속 발음이 아닌 경우
                if (word.substr(i, sound.size()) == sound && last_word != sound) {
                    last_word = sound;  // 현재 발음을 직전 발음으로 설정
                    i += sound.size();  // 발음 길이만큼 인덱스 이동
                    found = true;
                    break;
                }
            }

            // 가능한 발음을 찾지 못하면 유효하지 않은 단어
            if (!found) {
                is_valid = false;
                break;
            }
        }

        // 발음이 가능한 단어라면 개수 증가
        if (is_valid) {
            answer++;
        }
    }

    return answer;
}
