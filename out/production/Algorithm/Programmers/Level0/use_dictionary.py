

def solution(letter):
    answer = ""
    morse = { 
        '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
        '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
        '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
        '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
        '-.--':'y','--..':'z'
    }

    # Dictionary를 리스트로 바꾸면 key들만 담을 수 있다.
    check_list = list(morse)
    for i in letter.split(" "):
        for j in range(len(morse)):
            if i == check_list[j]:
                answer += morse[check_list[j]]
    return answer