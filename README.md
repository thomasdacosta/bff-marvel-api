# BFF Marvel API

BFF (Backends For Frontends) desenvolvido em Spring Boot que efeuta o acesso as API´s Oficiais da Marvel e busca o personagem, HQ´s e eventos de acordo com o nome pesquisado.

## Gerando o client da API da Marvel

Efetuar o cadastro no portal para obter as chaves e acesso a API da Marvel:

- https://developer.marvel.com/

Será necessário gerar um hash com as chaves da API da Marvel para efetuar as chamadas. Na documentação do Portal da Marvel existe a explicação. Sugestão de site que gera hash MD5:

- https://www.md5hashgenerator.com/

Baixar o Swagger do site abaixo:

- https://speca.io/speca/marvel-public-api-v1

Com o Swagger, gerar o código da aplicação através dos seguintes comandos:

```sh
wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.29/swagger-codegen-cli-3.0.29.jar -O swagger-codegen-cli.jar
java -jar swagger-codegen-cli.jar generate -i marvel-public-api-v1-swagger.json -l spring --library spring-cloud -o marvel
```
## Diretórios

- **bff-marvel:** aplicação Maven multi-module com as chamadas da API da Marvel
- **marvel:** exemplo de código gerado a partir do Swagger da API da Marvel

## Chamada da API

Efetuando a pesquisa a partir de um nome de herói:

```sh
curl --location --request GET 'http://localhost:8080/marvel/heros/iron man'
```

A resposta da chamada retorna por enquanto 20 registros de HQ´s e eventos:

```json
[
    {
        "id": 1009368,
        "name": "Iron Man",
        "description": "Wounded, captured and forced to build a weapon by his enemies, billionaire industrialist Tony Stark instead created an advanced suit of armor to save his life and escape captivity. Now with a new outlook on life, Tony uses his money and intelligence to make the world a safer, better place as Iron Man.",
        "comics": [
            {
                "title": "Death Of Doctor Strange: Avengers (2021) #1",
                "issueNumber": 1
            },
            {
                "title": "Shang-Chi (2021) #5",
                "issueNumber": 5
            },
            {
                "title": "Iron Man (2020) #13",
                "issueNumber": 13
            },
            {
                "title": "The Darkhold: Iron Man (2021) #1",
                "issueNumber": 1
            },
            {
                "title": "Dark Ages (2021) #2",
                "issueNumber": 2
            },
            {
                "title": "Infinite Destinies (Trade Paperback)",
                "issueNumber": 0
            },
            {
                "title": "Dark Ages (2021) #1",
                "issueNumber": 1
            },
            {
                "title": "Giant-Size Little Marvels Infinity Comic (2021) #2",
                "issueNumber": 2
            },
            {
                "title": "Avengers Annual (2021) #1",
                "issueNumber": 1
            },
            {
                "title": "Iron Man (2020) #11",
                "issueNumber": 11
            },
            {
                "title": "Daredevil (2019) #32",
                "issueNumber": 32
            },
            {
                "title": "Iron Man (2020) #10",
                "issueNumber": 10
            },
            {
                "title": "Iron Man (2020) #9",
                "issueNumber": 9
            },
            {
                "title": "Iron Man Annual (2021) #1",
                "issueNumber": 1
            },
            {
                "title": "Iron Man (2020) #8",
                "issueNumber": 8
            },
            {
                "title": "Man-Thing by Steve Gerber: The Complete Collection Vol. 3 (Trade Paperback)",
                "issueNumber": 0
            },
            {
                "title": "Iron Man (2020) #7",
                "issueNumber": 7
            },
            {
                "title": "Iron Man (2020) #6",
                "issueNumber": 6
            },
            {
                "title": "Iron Man (2020) #5",
                "issueNumber": 5
            },
            {
                "title": "King In Black: Iron Man/Doom (2020) #1",
                "issueNumber": 1
            }
        ],
        "events": [
            {
                "title": "Acts of Vengeance!",
                "description": "Loki sets about convincing the super-villains of Earth to attack heroes other than those they normally fight in an attempt to destroy the Avengers to absolve his guilt over inadvertently creating the team in the first place."
            },
            {
                "title": "Age of X",
                "description": "In a strange reality where the X-Men never came to be, the war between humans and mutants has escalated to a level never before seen. What has become of our heroes and who will survive as the final war commences?"
            },
            {
                "title": "Armor Wars",
                "description": "Tony Stark discovers that someone has been stealing his Iron Man tech and selling it to supervillains. He decides he must do whatever it takes to reacquire -- or destroy -- the stolen tech."
            },
            {
                "title": "Atlantis Attacks",
                "description": "Ghaur returns to complete his quest to resurrect the evil god Set, but his plan is opposed by Earth's heroes."
            },
            {
                "title": "Avengers Disassembled",
                "description": "Writer Brian Michael Bendis kicks off his historic run with the Avengers by bringing the previous era to a close alongside artist David Finch! Chaos reigns when of Earthâ€™s Mightiest Heroes turns against their teammates, leading the Avengers into a battle that not all will survive! Featuring Iron Man, Captain America, Hawkeye, the Scarlet Witch and more!"
            },
            {
                "title": "Avengers VS X-Men",
                "description": "A 12-issue event written by the unprecedented team of Brian Michael Bendis, Jason Aaron, Jonathan Hickman, Ed Brubaker and Matt Fraction with art by the blockbuster trio of John Romita Jr., Olivier Coipel and Adam Kubert, Avengers VS X-Men brings Marvel's biggest characters up against the greatest threat they've ever faced: each other!"
            },
            {
                "title": "Chaos War",
                "description": "When the Chaos King embarks on a campaign to wipe out all of existence, Hercules gathers the God Squad to stand in his way! Writers Greg Pak and Fred Van Lente join artist Khoi Pham to pit Herc and his rag tag teamâ€”including Thor, the Silver Surfer and Amadeus Choâ€”against an all-powerful evil as dead heroes and villains rise around them!"
            },
            {
                "title": "Civil War",
                "description": "After a horrific tragedy raises questions on whether or not super heroes should register with the government, longtime Avengers teammates Captain America and Iron Man end up on opposite sides of the argument! Writer Mark Millar and artist Steve McNiven split the Marvel Universe in two as friend fights friend in one of the most celebrated and successful events of all-time!"
            },
            {
                "title": "Crossing",
                "description": "Iron Man betrays the Avengers to Kang at the cost of several lives, ultimately including his own."
            },
            {
                "title": "Dark Reign",
                "description": "Norman Osborn came out the hero of Secret Invasion, and now the former Green Goblin has been handed control of the Marvel Universe. With his Cabal and the Dark Avengers at his side, can anything stop this long time villain from reshaping the world in his own image? And what has become of the heroes?"
            },
            {
                "title": "Enemy of the State",
                "description": "HYDRA, the Hand and a mutant group known as the Dawn of the White Light formed an alliance the purpose of which was to kill and resurrect superheroes under their control, starting with Wolverine. The alliance used Wolverine for various missions until he was recovered by S.H.I.E.L.D. and deprogrammed. Wolverine vowed to dismantle HYDRA and the Hand for what they did to him and for what they made him do."
            },
            {
                "title": "Fatal Attractions",
                "description": "Magneto returns, more powerful than ever, and Professor X realizes it's time for their decades-long conflict to end, permanently. Professor X and Magneto square off against each other aboard Asteroid M and after Magneto strips Wolverine of his adamantium Professor X destroys Magneto's mind. Colussus stays behind to care for Magneto since he has now defected to the Acolytes."
            },
            {
                "title": "Fear Itself",
                "description": "The Serpent, God of Fear and brother to the Allfather Odin, rises to challenge Earthâ€™s Mightiest in a seven-issue event written by Matt Fraction with art by Stuart Immonen! As the Worthy, heralds of the Serpent, lay waste to the Marvel Universe, how can Thor, Captain America, Iron Man and the Avengers turn back the tide of fear?"
            },
            {
                "title": "House of M",
                "description": "When the Scarlet Witch alters reality, the Avengers and X-Men face a world like none theyâ€™ve ever known! Writer Brian Michael Bendis and artist Olivier Coipel re-imagine the Marvel Universe with Magneto bringing mutantkind to prominence in an eight-issue event. As the only person who remembers how things used to be, can Wolverine set things right? Should he?"
            },
            {
                "title": "Infinity",
                "description": "While the most powerful Avengers journey into outer space in an attempt to unite the universe against the Builders, Thanos attacks the Earth in a six-issue event written by Jonathan Hickman with the art of Jim Cheung, Jerome Opena and Dustin Weaver! Featuring the Guardians of the Galaxy, the Inhumans and many more!"
            },
            {
                "title": "Infinity War",
                "description": "The Magus, the purged, evil side of Adam Warlock believed to have been dead, has returned in order to collect the Infinity Gems and recreate the Infinity Gauntlet itself. He sent evil doppelgangers of Marvel's superheroes to attack and usurp the originals. Thanos, exiled since his defeat during the Infinity Gauntlet event, learned of the Magus' plans and set out to aid Adam Warlock and the heroes in defending the universe."
            },
            {
                "title": "Inhumanity",
                "description": "Following Infinity, the actions of Black Bolt have affected not only his people, but the entire Marvel Universe, as a new race of Inhumans rises up! Witness change for every major Marvel character, led by Inhuman, a new series from Matt Fraction and Joe Madureira!"
            },
            {
                "title": "Initiative",
                "description": "After the partial destruction of Stamford, CT, the United States federal government enacted the Superhero Registration Act, a law designed to monitor, regulate, train and coordinate America's superheroes. The Initiative was an outgrowth of the SHRA, created by Tony Stark, the purpose of which was to place standby superhero teams in all 50 states."
            },
            {
                "title": "Maximum Security",
                "description": "At a meeting of the Shi'Ar intergalactic council, after numerous races lodge complaints against humanity, it is decided that Earth will become a prison planet. Unfortunately, one of the prisoners sentenced to Earth is Ego the Living Planet, who proceeds to expand exponentially, threatening the entire planet. It is soon discovered that one of the complaining races, the Ruul, are the Kree, whose Supreme Intelligence evolved them using the Destiny Crystal and manipulated the council to destroy Earth's heroes!"
            },
            {
                "title": "Onslaught",
                "description": "The evil within Professor Charles Xavier combines with the power of Magneto to create Onslaught, perhaps the greatest threat ever to the Marvel Universe! It begins with the X-Men, but before the end, the Avengers, the Fantastic Four and the rest of Earth's greatest heroes will know sacrifice before victory!"
            }
        ]
    }
]
```

---

Thomás da Costa - [https://thomasdacosta.com.br](https://thomasdacosta.com.br)
