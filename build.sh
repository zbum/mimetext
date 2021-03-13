#!/bin/bash

mvn clean package

mkdir -p $HOME/bin
cp target/mimetext ~/bin/
