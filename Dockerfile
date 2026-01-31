FROM ubuntu:latest
LABEL authors="shent"

ENTRYPOINT ["top", "-b"]