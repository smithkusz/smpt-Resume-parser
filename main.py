
from email import header
import docx2txt
import nltk
from email.headerregistry import ContentTypeHeader
from json import JSONDecoder
from resume_parser import resumeparse
from tkinter.tix import Form
from urllib import request
from pyresparser import ResumeParser
import pyresparser
from flask import Flask, jsonify
import os
from flask import Flask, flash, request, redirect, url_for
#!/usr/bin/python
# -*- coding: utf-8 -*-
import os
from pyresparser import ResumeParser
from flask import Flask, request, redirect, jsonify
from werkzeug.utils import secure_filename
from werkzeug.datastructures import ImmutableMultiDict


from flask import Flask

nltk.download('stopwords')


ALLOWED_EXTENSIONS = set(['pdf', 'docx'])
SKILLS_DB = [
    'machine learning','c','java','aws','mysql','h2','oracle','ruby','html','css','ajax',
    'data science','python','word','excel','English','C#', 'C++', 'HTML', 'JavaScript', 'XML', 'C','Perl','Python','PHP','Objective-C','AJAX','ASP.NET','Python',
]

# UPLOAD_FOLDER = 'C:/uploads'

app = Flask(__name__)

# app.secret_key = "secret key"
# app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
# app.config['MAX_CONTENT_LENGTH'] = 16 * 1024 * 1024

def extract_skills(input_text):
    stop_words = set(nltk.corpus.stopwords.words('english'))
    word_tokens = nltk.tokenize.word_tokenize(input_text)
 
    # remove the stop words
    filtered_tokens = [w for w in word_tokens if w not in stop_words]
 
    # remove the punctuation
    filtered_tokens = [w for w in word_tokens if w.isalpha()]
 
    # generate bigrams and trigrams (such as artificial intelligence)
    bigrams_trigrams = list(map(' '.join, nltk.everygrams(filtered_tokens, 2, 3)))
 
    # we create a set to keep the results in.
    found_skills = set()
 
    # we search for each token in our skills database
    for token in filtered_tokens:
        if token.lower() in SKILLS_DB:
            found_skills.add(token)
 
    # we search for each bigram and trigram in our skills database
    for ngram in bigrams_trigrams:
        if ngram.lower() in SKILLS_DB:
            found_skills.add(ngram)
 
    return found_skills

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() \
        in ALLOWED_EXTENSIONS

def extract_text_from_docx(docx_path):
    txt = docx2txt.process(docx_path)
    if txt:
        return txt.replace('\t', ' ')
    return None

@app.route('/uploader', methods = ['GET', 'POST'])
def upload_file_new():
   if request.method == 'POST':
      f = request.files['file']
      f.save(secure_filename(f.filename))
      return 'file uploaded successfully'

@app.route('/')
def hello_world():
    data = ResumeParser('E:\Sumit Java.pdf').get_extracted_data()
    print(data)
    return jsonify(data)

@app.route('/file-upload', methods=['POST'])
def upload_file():

    # check if the post request has the file part

    if 'file' not in request.files:
        resp = jsonify({'message': 'No file part in the request'})
        resp.status_code = 400
        return resp
    file = request.files['file']
    if file.filename == '':
        resp = jsonify({'message': 'No file selected for uploading'})
        resp.status_code = 400
        return resp
    if file and allowed_file(file.filename):
        print(file.content_type)
        filename = secure_filename(file.filename)
        file.save(secure_filename(file.filename))
        resp = jsonify({'message': 'File successfully uploaded'})
        data = ResumeParser(secure_filename(file.filename)).get_extracted_data();
        resp.status_code = 201
        # print(data)
        return jsonify(data)        
    else:
        resp = jsonify({'message': 'Allowed file types are docx, pdf'})
        resp.status_code = 400
        return resp

@app.route('/file-uploadOwnParser', methods=['POST'])
def upload_file_OwnParser():

    # check if the post request has the file part

    if 'file' not in request.files:
        resp = jsonify({'message': 'No file part in the request'})
        resp.status_code = 400
        return resp
    file = request.files['file']
    if file.filename == '':
        resp = jsonify({'message': 'No file selected for uploading'})
        resp.status_code = 400
        return resp
    if file and allowed_file(file.filename):
        
        print(file.content_type)
        filename = secure_filename(file.filename)
        file.save(secure_filename(file.filename))
        resp = jsonify({'message': 'File successfully uploaded'})
        data = extract_text_from_docx(secure_filename(file.filename))
        skills = extract_skills(data)
        resp.status_code = 201
        print(skills)
        return jsonify(data)        
    else:
        resp = jsonify({'message': 'Allowed file types are docx, pdf'})
        resp.status_code = 400
        return resp

if __name__ == "__main__":
    app.run(debug=True)
