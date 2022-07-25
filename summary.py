from typing import List
import os;

ITEM_SOLUTION = "best_solution.sol"
KERNEL_BUCKET = "list_k_b.txt"
TIME_SOLUTION = "log_best_solutions.txt"

def item_kernel_bucket(path: str, solution: List[str]) -> str:
    f_kernel = open(path, "r")
    group = "";
    count = 0;
    ritorno = "";
    for line in f_kernel:
        if not solution:
            ritorno = ritorno + group + ": " + str(count) + ";"
            break;
        if line.startswith('X'):
            variable = line.split()[0]
            if variable in solution:
                solution.remove(variable)
                count += 1
        else:
            if group != "" :
                ritorno = ritorno + group + ": " + str(count) + ";"
            group = line.strip()
            count = 0
    return ritorno

    #per ogni riga controllo se c'è un elemento di solution
    #se c'è lo aggiungo al return e lo rimuovo da solution 

def read_model(model: str) -> str:
    ritorno = model
    f_time = open(os.path.join(model, TIME_SOLUTION), "r")
    last_solution = f_time.readlines()[-1].split()
    ritorno = ritorno + ";" + last_solution[1] + ";" + last_solution[4] + ";"
    f_item = open(os.path.join(model, ITEM_SOLUTION), "r")
    solution = []
    for line in f_item:
        solution.append(line.split()[0])
    path_kernel = os.path.join(model, KERNEL_BUCKET)
    ritorno = ritorno + item_kernel_bucket(path_kernel, solution)
    return ritorno;


def summary_family(family):
    os.chdir(family)
    with open("sintesi.txt", "w") as file:
        list_model = os.listdir()
        list_model.sort()
        for model in list_model:
            if os.path.isfile(model):
                continue
            summary = read_model(model)
            file.write(summary + "\n")

    os.chdir("..")


def main():
    os.chdir("risultati")
    for family in os.listdir():
        summary_family(family)

if __name__ == "__main__":
    main()