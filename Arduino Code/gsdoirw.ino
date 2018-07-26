#include <SoftwareSerial.h>

SoftwareSerial BTserial(10, 11); // RX | TX
int D0=2;
int sensorPin = D0;
int sensorValue = 0;

void setup() {
  BTserial.begin(9600); 
  }
  
void loop() {
  sensorValue = digitalRead(sensorPin);
  BTserial.print(sensorValue);
  delay(20);
  }
