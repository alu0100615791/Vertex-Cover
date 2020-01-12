# Vertex-Cover

El problema Vertex Cover, o en español Cobertura de vertices, es un problema NP-Completo. El Vertex Cover está compuesto por un grafo G={v,e} y un entero positivo k.
La solución consiste en hallar un subgrafo de G, con un máximo de k vértices, donde dichos vértices tengan acceso a todas las aristas del grafo.

Partiendo de una instancia de 3-SAT: U={u1, u2, …, un} y C={c1, c2, …, cm}.
Se debe obtener un grafo G={v,e} y hallar el problema de la cobertura de vértices.

El programa leerá un fichero txt con la siguiente estructura:

```
2
u1 !u1 u2
u2 !u2 u1
```

Con el primer número creará los literales llamadonlos en este ejemplo (u1L, -u1L. u2L, -u2L) y posteriormente crearás las clausulas de 3 Sat con las siguientes lineas
