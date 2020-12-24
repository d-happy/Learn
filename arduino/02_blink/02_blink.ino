void setup() {
  // 1번만 실행할 코드 (설정값)
  pinMode(13, OUTPUT); // 내정된 핀번호를 출력용으로 설정
}

void loop() {
  // 무한반복
  digitalWrite(13, HIGH);
  // Thread.sleep(1000)
  delay(1000);
  digitalWrite(13, LOW);
  delay(1000);
}
