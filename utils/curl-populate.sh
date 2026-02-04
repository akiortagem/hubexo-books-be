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

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Lusty Argonian Maid","author":"Crassius Curio","isbn":"9780000010001","pubYear":"2011","genre":"Fiction","desc":"A delightfully scandalous stage play beloved across Tamriel."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Real Barenziah","author":"Anonymous","isbn":"9780000010018","pubYear":"2011","genre":"Fiction","desc":"The unofficial biography that every court swears is banned."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Book of the Dragonborn","author":"Weylin","isbn":"9780000010025","pubYear":"2011","genre":"Fiction","desc":"A scholarly primer on dragon lore and the Last Dragonborn."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"A Dance in Fire","author":"Waughin Jarth","isbn":"9780000010032","pubYear":"2011","genre":"Fiction","desc":"A swashbuckling romance and intrigue across the Iliac Bay."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Thief of Virtue","author":"Giraud Gemane","isbn":"9780000010049","pubYear":"2011","genre":"Fiction","desc":"A cautionary tale about choices, consequences, and stolen honor."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Fantastic Beasts and Where to Find Them","author":"Newt Scamander","isbn":"9780000010056","pubYear":"2001","genre":"Fantasy","desc":"A field guide to magical creatures by a celebrated magizoologist."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Quidditch Through the Ages","author":"Kennilworthy Whisp","isbn":"9780000010063","pubYear":"2001","genre":"Fantasy","desc":"The definitive history and lore of the wizarding sport."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Tales of Beedle the Bard","author":"Beedle the Bard","isbn":"9780000010070","pubYear":"2007","genre":"Fantasy","desc":"Classic wizarding fairy tales with curious moral lessons."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Hogwarts: A History","author":"Bathilda Bagshot","isbn":"9780000010087","pubYear":"1947","genre":"Fantasy","desc":"A meticulous chronicle of Hogwarts School of Witchcraft and Wizardry."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"A History of Magic","author":"Bathilda Bagshot","isbn":"9780000010094","pubYear":"1949","genre":"Fantasy","desc":"A foundational text on the evolution of magical society."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Magical Theory","author":"Adalbert Waffling","isbn":"9780000010100","pubYear":"1945","genre":"Fantasy","desc":"Principles and fundamentals of spellcraft and magical study."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Standard Book of Spells (Grade 1)","author":"Miranda Goshawk","isbn":"9780000010117","pubYear":"1984","genre":"Fantasy","desc":"Essential spells for first-year witches and wizards."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Advanced Potion-Making","author":"Libatius Borage","isbn":"9780000010124","pubYear":"1946","genre":"Fantasy","desc":"A challenging compendium for ambitious potioneers."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Fantastic Beasts: A Child’s Guide","author":"Newt Scamander","isbn":"9780000010131","pubYear":"1995","genre":"Fantasy","desc":"A simplified introduction to magical creatures for young readers."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Travels with Trolls","author":"Martin Miggs","isbn":"9780000010148","pubYear":"1969","genre":"Fantasy","desc":"A boastful but entertaining adventure across troll country."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Moste Potente Potions","author":"Arsenius Jigger","isbn":"9780000010155","pubYear":"1850","genre":"Fantasy","desc":"A classic reference for complex and volatile brews."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Secrets of the Darkest Art","author":"Unknown","isbn":"9780000010162","pubYear":"1890","genre":"Fantasy","desc":"A forbidden volume on the darkest branches of magic."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Life and Lies of Albus Dumbledore","author":"Rita Skeeter","isbn":"9780000010179","pubYear":"1997","genre":"Fantasy","desc":"A sensational biography full of scandal and rumor."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Dark Forces: A Guide to Self-Protection","author":"Quentin Trimble","isbn":"9780000010186","pubYear":"1970","genre":"Fantasy","desc":"Methods and countermeasures for defensive magic."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Defensive Magical Theory","author":"Wilbert Slinkhard","isbn":"9780000010193","pubYear":"1960","genre":"Fantasy","desc":"A controversial text on defensive spellcasting."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Monster Book of Monsters","author":"Edwardus Lima","isbn":"9780000010209","pubYear":"1975","genre":"Fantasy","desc":"Handle with care: a living text on monstrous beasts."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Unfogging the Future","author":"Cassandra Vablatsky","isbn":"9780000010216","pubYear":"1980","genre":"Fantasy","desc":"An introduction to divination and the art of foresight."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"One Thousand Magical Herbs and Fungi","author":"Phyllida Spore","isbn":"9780000010223","pubYear":"1978","genre":"Fantasy","desc":"A comprehensive guide to magical plants and fungi."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Standard Book of Spells (Grade 2)","author":"Miranda Goshawk","isbn":"9780000010230","pubYear":"1985","genre":"Fantasy","desc":"Second-year spellwork and practical incantations."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Standard Book of Spells (Grade 3)","author":"Miranda Goshawk","isbn":"9780000010247","pubYear":"1986","genre":"Fantasy","desc":"Intermediate spells for third-year students."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Jedi Path","author":"Daniel Wallace","isbn":"9780000010254","pubYear":"2010","genre":"Sci-Fi","desc":"A training manual for Jedi from youngling to master."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Book of Sith","author":"Daniel Wallace","isbn":"9780000010261","pubYear":"2012","genre":"Sci-Fi","desc":"Collected writings and secrets of the Sith Order."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Bounty Hunter Code","author":"Daniel Wallace","isbn":"9780000010278","pubYear":"2009","genre":"Sci-Fi","desc":"Field guide for hunters, scoundrels, and survivalists."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Imperial Handbook","author":"Daniel Wallace","isbn":"9780000010285","pubYear":"2009","genre":"Sci-Fi","desc":"Official-looking manual of the Galactic Empire."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Scoundrels’ Guide","author":"Smugglers’ Council","isbn":"9780000010292","pubYear":"2016","genre":"Sci-Fi","desc":"Tips, tricks, and lore from the galaxy’s underworld."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"HoloNet News Almanac","author":"HoloNet News","isbn":"9780000010308","pubYear":"2018","genre":"Sci-Fi","desc":"Yearly digest of galactic events and politics."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Wookieepedia Field Notes","author":"Archivist Chewbacca","isbn":"9780000010315","pubYear":"2015","genre":"Sci-Fi","desc":"A shaggy, heartfelt compendium of species and worlds."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Tales from the Mos Eisley Cantina","author":"A. Wookiee Bard","isbn":"9780000010322","pubYear":"1995","genre":"Sci-Fi","desc":"Stories of smugglers, bounty hunters, and barstool legends."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Droids and Their Makers","author":"Binary Technologists Guild","isbn":"9780000010339","pubYear":"1977","genre":"Sci-Fi","desc":"An illustrated survey of droid models and makers."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Corellian Hyperroutes","author":"Corellian Merchants League","isbn":"9780000010346","pubYear":"1988","genre":"Sci-Fi","desc":"A navigator’s guide to shipping lanes and shortcuts."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Rebel Alliance Field Manual","author":"Alliance Command","isbn":"9780000010353","pubYear":"1980","genre":"Sci-Fi","desc":"Tactics, codes, and survival for rebel operatives."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The New Republic Charter","author":"Chandrila Council","isbn":"9780000010360","pubYear":"1999","genre":"Sci-Fi","desc":"Founding principles and laws of the New Republic."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Huttese for Diplomats","author":"Jabba the Linguist","isbn":"9780000010377","pubYear":"1990","genre":"Sci-Fi","desc":"A dubious but popular phrasebook for negotiations."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Astromech Repair 101","author":"Industrial Automaton","isbn":"9780000010384","pubYear":"1979","genre":"Sci-Fi","desc":"Basic maintenance and troubleshooting for astromechs."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Starship Silhouettes","author":"Kuat Drive Yards","isbn":"9780000010391","pubYear":"1983","genre":"Sci-Fi","desc":"Recognition guide to vessels from freighters to dreadnoughts."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Sith Code","author":"Qordis","isbn":"9780000010407","pubYear":"2014","genre":"Sci-Fi","desc":"A terse meditation on passion, strength, and power."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Jedi Artifacts","author":"Jocasta Nu","isbn":"9780000010414","pubYear":"2002","genre":"Sci-Fi","desc":"Catalog of lightsabers, holocrons, and relics."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Smuggler’s Run","author":"Lando Calrissian","isbn":"9780000010421","pubYear":"2015","genre":"Sci-Fi","desc":"A fast-paced memoir of heists and hyperspace jumps."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Jedi vs. Sith: The Essential Guide","author":"Ryder Windham","isbn":"9780000010438","pubYear":"2007","genre":"Sci-Fi","desc":"A concise history of the ancient rivalry."}'

curl -sS -X POST "$BASE_URL/api/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"The Complete Encyclopedia of Star Wars","author":"Pablo Hidalgo","isbn":"9780000010445","pubYear":"2008","genre":"Sci-Fi","desc":"A sweeping compendium of people, places, and lore."}'
