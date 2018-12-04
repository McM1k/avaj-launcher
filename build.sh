#!/usr/bin/env bash

find . -name "*.java" > sources.txt
mkdir build
javac -cp @sources.txt -d ./build/
java -cp build/ simulation.Simulation $@
rm -r build