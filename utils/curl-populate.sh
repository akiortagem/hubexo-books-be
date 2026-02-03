#!/usr/bin/env bash
set -euo pipefail

BASE_URL="${BASE_URL:-http://localhost:8080}"

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Clean Code","author":"Robert C. Martin","isbn":"9780132350884","pubYear":"2008","genre":"Software","desc":"A handbook of agile software craftsmanship."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Designing Data-Intensive Applications","author":"Martin Kleppmann","isbn":"9781449373320","pubYear":"2017","genre":"Software","desc":"The big ideas behind reliable, scalable, and maintainable systems."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Refactoring","author":"Martin Fowler","isbn":"9780201485677","pubYear":"1999","genre":"Software","desc":"Improving the design of existing code."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Domain-Driven Design","author":"Eric Evans","isbn":"9780321125217","pubYear":"2003","genre":"Software","desc":"Tackling complexity in the heart of software."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Pragmatic Programmer","author":"Andrew Hunt, David Thomas","isbn":"9780201616224","pubYear":"1999","genre":"Software","desc":"Journey to mastery for pragmatic software development."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Effective Java","author":"Joshua Bloch","isbn":"9780134685991","pubYear":"2018","genre":"Software","desc":"Best practices for the Java platform."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Java Concurrency in Practice","author":"Brian Goetz","isbn":"9780321349606","pubYear":"2006","genre":"Software","desc":"Building thread-safe, concurrent Java applications."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Working Effectively with Legacy Code","author":"Michael Feathers","isbn":"9780131177055","pubYear":"2004","genre":"Software","desc":"Techniques for changing existing code safely."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Head First Design Patterns","author":"Eric Freeman, Elisabeth Robson","isbn":"9780596007126","pubYear":"2004","genre":"Software","desc":"A brain-friendly guide to design patterns."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Mythical Man-Month","author":"Frederick P. Brooks Jr.","isbn":"9780201835953","pubYear":"1995","genre":"Software","desc":"Essays on software engineering and project management."}'
