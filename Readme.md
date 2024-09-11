Tech Stack
Java 17
Ollama - LLM
https://docs.spring.io/spring-ai/reference/api/embeddings/ollama-embeddings.html
Spring AI


Current implementation uses ollama for embedding.

Install ollama
https://ollama.com/download/mac

Run - ollama run llama3.1
Pull pre-trained model - ollama pull chroma/all-minilm-l6-v2-f32
Pull pre-trained model if want to use mistral - ollama pull mistral


Some example of query 
-------------------------
Back to the future
Strong man
I want to see ghost movie
want to see gangster movies
Movie with suspense murder and crime
Movie related to spider man
I want to see gangster's movie
Suggest movie related to super hero or spider man

Tech stack exploring
---------------------
https://github.com/pgvector/pgvector
ONNX transformer
git clone https://github.com/postgresml/postgresml
cd postgresml
cd pgml-extension && brew bundle

Running on docker 
-------------------
docker run \
-it \
-v postgresml_data:/var/lib/postgresql \
-p 5433:5432 \
-p 8000:8000 \
ghcr.io/postgresml/postgresml:2.9.3 \
sudo -u postgresml psql -d postgresml


…or create a new repository on the command line
echo "# semanticsearch" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/ravisingh111076/semanticsearch.git
git push -u origin main
…or push an existing repository from the command line
git remote add origin https://github.com/ravisingh111076/semanticsearch.git
git branch -M main
git push -u origin main