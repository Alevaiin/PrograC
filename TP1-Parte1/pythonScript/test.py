import os


def main():
    pid = os.fork()
    print(f"Process ID: {pid}")


if __name__ == "__main__":
    main()
