New_York_City = []
Houston = []
Los_Angeles = []
Rejects_bin = []

while True:

    input_numbers = int(input("Insert number: "))

    numbers = [input_numbers]

    for number in numbers:
        if number >= 0 and number < 35:
            New_York_City.append(number)
        elif number >= 35 and number < 70:
            Houston.append(number)
        elif number >= 70 and number < 100:
            Los_Angeles.append(number)
        elif number < 35 or number > 100:
            Rejects_bin.append(number)
            print("Rejects bin")

    print("New York City:", New_York_City)
    print("Houston:", Houston)
    print("Los Angeles:", Los_Angeles)
    print("Rejects bin:", Rejects_bin)